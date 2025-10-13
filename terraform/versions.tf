terraform {
  required_version = ">=0.15"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~>2.0"
    }
  }
}

provider "aws" {
  region = "ap-south-1"
}

provider "aws" {
  alias = "eu-west-1"
  region = "eu-west-1"
}