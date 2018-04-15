import { Injectable } from '@angular/core';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';
import { ACCESS_KEY_ID, SECRET_ACCESS_KEY,BUCKET } from '../../environments/environment';
 
@Injectable()
export class UploadService {
 
  FOLDER = 'jsa-s3/';
 
  constructor() { }
 
  uploadfile(file) {
 
    const bucket = new S3(
      {
        accessKeyId: `${ACCESS_KEY_ID}`,
        secretAccessKey: `${SECRET_ACCESS_KEY}`,
        region: 'us-east-1'
      }
    );
 
    const params = {
      Bucket: `${BUCKET}`,
      Key: this.FOLDER + file.name,
      Body: file
    };
 
    bucket.upload(params, function (err, data) {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return false;
      }
 
      console.log('Successfully uploaded file.', data);
      return true;
    });
  }
 
}