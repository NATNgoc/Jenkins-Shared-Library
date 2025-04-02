#!/usr/bin/env groovy

package ngoc

class Node implements Serializable {
    private def script

    /**
     * Constructor
     *
     * @param script Reference to the pipeline script
     */
    Node(script) {
        this.script = script
    }

    /**
     * Execute a closure on a specific node
     *
     * @param body Closure to execute
     * @return Result of the closure execution
     */

    def installLibary() {
        this.script.sh "npm i --save"
    }

    def testing() {
        this.script.sh "npm run test"
    }

    def building() {
        this.script.sh "npm run build"
    }

    def versioning(String option) {
        // Validate option is one of the allowed values
        if (!["patch", "major", "minor"].contains(option)) {
            throw new IllegalArgumentException("Invalid version option: '${option}'. Must be one of: patch, major, minor")
        }
        
        // Use the validated option
        this.script.sh "npm version ${option}"
    }

    def getCurVersionNumber() {
        return this.script.sh(script: "npm pkg get version", returnStdout: true).trim().replaceAll('"', '')
    }
}