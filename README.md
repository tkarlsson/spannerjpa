# Spanner JPA

An example application that uses Spring Boot Data JPA Repositories to save and read information from Cloud Spanner

## Configure

## Deploy
$PROJECT_NAME - Project name for deployment
$SA - Service account to run the service
$REGION - Region to deploy

gcloud run deploy spannerjpa --quiet --image gcr.io/${PROJECT_NAME}/spannerdemos/spannerjpa --platform managed --project $PROJECT_NAME --service-account $SA --memory 512Mi --timeout 300 --concurrency 80 --max-instances 1 --cpu 1 --set-env-vars SPRING_CLOUD_GCP_LOGGING_PROJECT_ID=${PROJCECT_NAME},spring.profiles.active=testgcp --region ${REGION}

## Run
gcurl='curl --header "Authorization: Bearer $(gcloud auth print-identity-token)"'
gcurl https://<service url>.a.run.app/
