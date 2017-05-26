#!/usr/bin/env groovy

/**
 * Sample Jenkinsfile for Jenkins2 Pipeline
 * from https://github.com/hotwilson/jenkins2/edit/master/Jenkinsfile
 * by wilsonmar@gmail.com
 */

import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import java.net.URL

try {
  node {
    stage 'Stage 1'
    echo "BUILD_URL=${env.BUILD_URL}"
    def workspace = pwd()
    echo "workspace=${workspace}"

    stage 'Stage 2'
    } // node
} // try end
catch (exc) {
  echo "Caught: ${exc}"

  String recipient = 'jejiv@yahoo.com'

  mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) failed",
          body: "It appears that ${env.BUILD_URL} is failing, somebody should do something about that",
            to: recipient,
       replyTo: recipient,
          from: 'noreply@ci.jenkins.io'
}
