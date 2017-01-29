#!groovy

node {
  def mvnHome = tool 'M3'
  properties([pipelineTriggers([[$class: 'GitHubPushTrigger']])])
  
  stage('Get Repo')
  git url: 'git@github.com:sebastiangraf/jSCSI.git'
  
  stage('Unit Tests')
  sh "${mvnHome}/bin/mvn -B clean test"
  step([$class: 'Publisher'])
  
  
  if (BRANCH_NAME.equals('master')) {
    stage('Deploy Snapshot since on main branch')
    sh "${mvnHome}/bin/mvn -B -DskipTests=true clean deploy"  
  } else {
    echo "Skipping deploy since not on master branch but on branch " + BRANCH_NAME
  }
    
  
}
