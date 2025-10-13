data "aws_ami" "example" {
  most_recent      = true
  owners           = ["amazon"]

  filter {
    name   = "name"
    values = ["al2023-ami-2023.9.20250929.0-kernel-6.1*"]
  }


  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }
  filter {
    name   = "architecture"
    values = ["x86_64"]
  }
}

data "aws_ami" "example_eu_west_1" {
  provider = aws.eu-west-1
  most_recent      = true
  owners           = ["amazon"]

  filter {
    name   = "name"
    values = ["al2023-ami-2023.9.20250929.0-kernel-6.1*"]
  }


  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }
  filter {
    name   = "architecture"
    values = ["x86_64"]
  }
}