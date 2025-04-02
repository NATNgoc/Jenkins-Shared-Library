#!/usr/bin/env groovy

import ngoc.Node

def call(String option) {
    return new Node(this).versioning(option)
}