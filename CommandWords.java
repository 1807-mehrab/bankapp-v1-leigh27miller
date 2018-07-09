public class CommandWords {
    private static final String[] validCommands = {
        "withdraw" , "deposit" , "quit"
    };

    public CommandWords() {}

    public boolean isCommand(String input){
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(input)) {
                return true;
            }
        }
    return false;
    }
    
    public void showAll() {
        for(String command : validCommands) {
            System.out.print(command + " ");
        }

        System.out.println();
    }
}