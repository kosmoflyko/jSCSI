#!groovy

node {
  def mvnHome = tool 'M3'
  
  stage('Get Repo')
  git url: 'git@github.com:sebastiangraf/jSCSI.git'
  
  stage('jUnit Tests')
  sh "${mvnHome}/bin/mvn -B clean test"
  junit '**/target/*.xml'
  
  stage('Deploy Snapshot')
  sh "${mvnHome}/bin/mvn -B -DskipTests=true clean deploy"
}