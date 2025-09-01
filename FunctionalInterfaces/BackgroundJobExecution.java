public class BackgroundJobExecution {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        Runnable dataProcessingJob = () -> {
            System.out.println("Data processing job started in background");
            try {
                Thread.sleep(2000); // Simulate processing time
                System.out.println("Data processing completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable emailSendingJob = () -> {
            System.out.println("Email sending job started in background");
            try {
                Thread.sleep(1500); // Simulate sending time
                System.out.println("Emails sent successfully");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Execute jobs in separate threads
        Thread dataThread = new Thread(dataProcessingJob);
        Thread emailThread = new Thread(emailSendingJob);

        dataThread.start();
        emailThread.start();

        // Wait for both threads to complete
        try {
            dataThread.join();
            emailThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed");
    }
}
