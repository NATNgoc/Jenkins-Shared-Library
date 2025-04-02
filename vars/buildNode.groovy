#!/usr/bin/env groovy

import ngoc.Node

def call() {
    return new Node(this).building()
}