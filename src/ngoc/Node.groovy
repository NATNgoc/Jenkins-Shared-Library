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
    def testing() {
        this.script.sh "npm run test"
    }

    def building() {
        this.script.sh "npm run build"
    }

}