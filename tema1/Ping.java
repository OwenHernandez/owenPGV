public class Ping {

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("ping", "google.es");

        try{
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
