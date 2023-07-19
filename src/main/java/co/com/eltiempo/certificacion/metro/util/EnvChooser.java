package co.com.eltiempo.certificacion.metro.util;

public class EnvChooser {

    public static String chooseEnv(String env) throws EnvironmentNotFoundException {
        switch (env) {
            default : throw new EnvironmentNotFoundException();
            case "QA" : {
                return "14bVpl8QeJuEKqaFRwWQ0Wv4_tdAICZEE99Tx5FWRjEY";
            }
            case "PROD" : {
                return "18kp7o0swPoIMogOL10jz4xhTN84xkuH9HY4x8dIC_1c";
            }
        }
    }
}
