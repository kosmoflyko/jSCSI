#!groovy

node {
  git url: 'git@github.com:sebastiangraf/jSCSI.git'
  def mvnHome = tool 'M3'
  sh "${mvnHome}/bin/mvn -B -Dmaven.test.failure.ignore verify"
  step([$class: 'JUnitResultArchiver', testResults:
'**/target/foobar/TEST-*.xml'])
}