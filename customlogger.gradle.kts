useLogger(CustomEventLogger())

class CustomEventLogger() : BuildAdapter(), TaskExecutionListener {
    override fun beforeExecute(task: Task) { }
    override fun afterExecute(task: Task, state: TaskState) { }
    override fun buildFinished(result: BuildResult) {
        println()
        if (result.failure != null) {
            println("Build completed with errors".red)
        } else {
            println("Build completed".green)
        }
    }

    val String.red: String get() { return "\u001b[31m$this\u001b[0m" }
    val String.green: String get() { return "\u001b[32m$this\u001b[0m" }
}