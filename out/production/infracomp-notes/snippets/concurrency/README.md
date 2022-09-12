# Concurrency

In computer science, concurrency is the ability of different parts or units of a program, algorithm, or problem to be executed out-of-order or in partial order, without affecting the final outcome. This allows for parallel execution of the concurrent units, which can significantly improve overall speed of the execution in multi-processor and multi-core systems. In more technical terms, concurrency refers to the decomposability of a program, algorithm, or problem into order-independent or partially-ordered components or units of computation. (Wikipedia)

## Themes

### Mutual exclusion
In computer science, mutual exclusion is a property of concurrency control, which is instituted for the purpose of preventing race conditions. It is the requirement that one thread of execution never enters a critical section while a concurrent thread of execution is already accessing said critical section, which refers to an interval of time during which a thread of execution accesses a shared resource or shared memory.

The shared resource is a data object, which two or more concurrent threads are trying to modify (where two concurrent read operations are permitted but, no two concurrent write operations or one read and one write are permitted, since it leads to data inconsistency). Mutual exclusion algorithm ensures that if a process is already performing write operation on a data object [critical section] no other process/thread is allowed to access/modify the same object until the first process has finished writing upon the data object [critical section] and released the object for other processes to read and write upon.

- Semaphores
- Barriers
- Processes
- Monitors
- Events
