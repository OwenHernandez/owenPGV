public class IpConfig {

    public static void main(String[] args) {
        //lanzarProceso("xfce4-terminal");
        ProcessBuilder processBuilder = new ProcessBuilder("ifconfig");

        try{
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
