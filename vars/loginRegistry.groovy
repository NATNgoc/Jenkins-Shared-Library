#!/usr/bin/env groovy

import ngoc.Docker

def call(String idCrendential) {
    return new Docker(this).dockerLogin(idCrendential)
}