terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.81.0"
    }
  }
}
provider "aws" {
  region = "ap-south-1"
}

resource "aws_s3_bucket" "tf_state" {
  bucket = "fil-session-terraform-s3-remote-backend"
  lifecycle {
    prevent_destroy = true
  }
  tags = {
    Name = "TerraformStateBucket"
  }
}

resource "aws_dynamodb_table" "tf_lock" {
  name = "terraform-state-lock"
  hash_key     = "LockID"
  billing_mode = "PAY_PER_REQUEST"

  attribute {
    name = "LockID"
    type = "S"
  }

  tags = {
    Name = "TerraformStateLockTable"
  }
}