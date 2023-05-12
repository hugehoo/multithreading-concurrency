- Threads consume resources
  - Memory and Kernel resources
  - CPU cycles and cache memory
- If a thread finished its work, but the application is still running, we want to clean up the resource of thread.
- If a thread is misbehaving, we want to stop it.
- **By default, the application will not stip as lonf as at least one thread is still running**

Thread.interrupt()

Daemon Threads
- Background threads that do not prevent the application from exiting if the main thread terminates.
- Background tasks, that should not block our application from terminating.
- **To prevent a thread from blocking our app from exiting, we set the thread to be a Daemon thread.**