terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~>5.81.0"
    }
  }

  backend "s3" {

  }
}
provider "aws" {
  region = var.region
}