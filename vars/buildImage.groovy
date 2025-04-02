#!/usr/bin/env groovy

import ngoc.Docker

def call(String imageName, String pathToDockerFile = '.') {
    return new Docker(this).buildDockerImage(imageName, pathToDockerFile)
}