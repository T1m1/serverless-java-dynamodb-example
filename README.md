## Serverless Framework for AWS Lambda - Java + DynamoDB Example

### How to use [Serverless Framework](https://github.com/serverless/serverless)

* ##### Create a new Serverless Service:
  * `serverless create --template aws-java-gradle --path my-service`
  * Available templates: aws-nodejs, aws-python, aws-java-maven, aws-java-gradle, aws-scala-sbt

* ##### Deploy Function:
  * Use this to quickly upload and overwrite your AWS Lambda code on AWS, allowing you to develop faster.
  * `serverless deploy function -f myfunction`

* ##### Invoke a Function:
  * Invokes an AWS Lambda Function on AWS and returns logs.
  * `serverless invoke -f hello -l`

### How to use this example

* ##### Create and export your AWS access keys:
  * [Create AWS credentials](http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSGettingStartedGuide/AWSCredentials.html)
  * Export AWS_SECRET_ACCESS_KEY and AWS_ACCESS_KEY_ID
  * `export AWS_ACCESS_KEY=ABCDEFGHIJK****`
  * `export AWS_SECRET_ACCESS_KEY=+KAABCDEFGH/IJK*******`

* ##### Build zip file
  * `gradle clean buildZip`

* ##### Deploy Funktion
  * Lambda function will be deployed
  * DynamoDB will be created
  * `serverless deploy`

* ##### Invoke function to create dataset (POST)
 *  `serverless invoke -f createRating  --path data.json`

* ##### Invoke function to get all dataset with chargeStationId from data.json (POST)
 *  `serverless invoke -f getRating --path data.json`


