# 1. Create ECS Cluster
resource "aws_ecs_cluster" "ecs-cluster" {
  name = "ecs-cluster-fil"
  setting {
    name  = "containerInsights"
    value = "enabled"
  }
  tags = {
    Name = "ecs-cluster-fil"
  }
}



# 2. Create Task Definition
resource "aws_ecs_task_definition" "jenkins-task-td" {
  family                = "jenkins-task-definition"
  network_mode = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  execution_role_arn = aws_iam_role.jenkins-task-execution-role.arn
  cpu = 2048
  memory = 4096
  container_definitions = jsonencode([
  {
    name      = "jenkins"
    image     = "jenkins/jenkins:lts-jdk17"
    cpu       = 2048
    memory    = 4096
    essential = true
    portMappings = [
      {
        containerPort = 8080
        hostPort      = 8080
      }

    ]
    # logConfiguration = {
    #   logDriver = "awslogs"
    #   options = {
    #     awslogs-group = "/jenkins/server"
    #     awslogs-region = "ap-south-1"
    #     awslogs-stream-prefix = "jenkins"
    #   }
    # }
}])

}

data "aws_iam_policy_document" "jenkins-task-role-policy" {
  statement {
    actions = ["sts:AssumeRole"]

    principals {
      type        = "Service"
      identifiers = ["ecs-tasks.amazonaws.com"]
    }
  }
}


# 3. Create Task Role
# resource "aws_iam_role" "jenkins-task-role" {
#   name = "fil-jenkins-task-role"
#   # assume_role_policy = data.aws_iam_policy_document.jenkins-task-role-policy.json
# }

# 4. Create Task Execution Role
resource "aws_iam_role" "jenkins-task-execution-role" {
  name = "fil-jenkins-task-execution-role"
  assume_role_policy = data.aws_iam_policy_document.jenkins-task-role-policy.json
}

resource "aws_iam_role_policy_attachment" "jenkins-ecs-execution-role-attachment" {
  policy_arn = "arn:aws:iam::aws:policy/service-role/AmazonECSTaskExecutionRolePolicy"
  role       = aws_iam_role.jenkins-task-execution-role.name
}

# 5.1 Create ECS Security Group
resource "aws_security_group" "jenkins-ecs-sg" {
  name = "jenkins-ecs-sg"
  ingress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }
  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }
}

# 5.2 Create ECS Service
resource "aws_ecs_service" "jenkins-ecs-service" {
  name            = "jenkins-ecs-service"
  cluster         = aws_ecs_cluster.ecs-cluster.id
  task_definition = aws_ecs_task_definition.jenkins-task-td.arn
  desired_count   = 1
  network_configuration {
    security_groups = [aws_security_group.jenkins-ecs-sg.id]
    subnets = ["subnet-0edd139551b5c1af9", "subnet-08395d9af34347c06"]
  }

  # ordered_placement_strategy {
  #   type  = "binpack"
  #   field = "cpu"
  # }

  # load_balancer {
  #   target_group_arn = aws_lb_target_group.foo.arn
  #   container_name   = "mongo"
  #   container_port   = 8080
  # }

  # placement_constraints {
  #   type       = "memberOf"
  #   expression = "attribute:ecs.availability-zone in [us-west-2a, us-west-2b]"
  # }
}