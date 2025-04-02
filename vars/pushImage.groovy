#!/usr/bin/env groovy

import ngoc.Docker

def call(String imageName) {
    return new Docker(this).dockerPush(imageName)
}