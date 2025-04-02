#!/usr/bin/env groovy

import ngoc.Docker

def call(String idCrendential, String host='') {
    return new Docker(this).dockerLogin(idCrendential, host)
}