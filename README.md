## Serverless Framework for AWS Lambda - Java + DynamoDB Example

### How to use [Serverless Framework](https://github.com/serverless/serverless)

* ##### Create a new Serverless Service:
  * `serverless create --template aws-java-gradle --path my-service`
  * Available templates: aws-nodejs, aws-python, aws-java-maven, aws-java-gradle, aws-scala-sbt

* ##### Create a new Serverless Service:
  * `serverless create --template aws-java-gradle --path my-service`
  * Available templates: aws-nodejs, aws-python, aws-java-maven, aws-java-gradle, aws-scala-sbt

* ##### Deploy Function:
  * Use this to quickly upload and overwrite your AWS Lambda code on AWS, allowing you to develop faster.
  * `serverless deploy function -f myfunction`

* ##### Invoke a Function:
  * Invokes an AWS Lambda Function on AWS and returns logs.
  * `serverless invoke -f hello -l`
