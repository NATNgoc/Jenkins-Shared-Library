#!/usr/bin/env groovy

package ngoc

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String pathToDockerFile = '.') {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName $pathToDockerFile"
    }

    def dockerLogin(String idCredential) {
        script.withCredentials([script.usernamePassword(credentialsId: "$idCredential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}
