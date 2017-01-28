#!groovy

node {
  def mvnHome = tool 'M3'
  properties([pipelineTriggers([$class: 'GitHubPushTrigger'])])
  
  stage('Get Repo')
  git url: 'git@github.com:sebastiangraf/jSCSI.git'
  
  stage('jUnit Tests')
  sh "${mvnHome}/bin/mvn -B clean test"
  step([$class: 'Publisher'])
  
  stage('Deploy Snapshot')
  sh "${mvnHome}/bin/mvn -B -DskipTests=true clean deploy"
}