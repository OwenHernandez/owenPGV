public class App {

    public static void lanzarProceso(String proceso){
        ProcessBuilder processBuilder = new ProcessBuilder(proceso);

        try{
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //lanzarProceso("xfce4-terminal");
        ProcessBuilder processBuilder = new ProcessBuilder("cat", "/home/dam2/Escritorio/coso.txt");

        try{
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
