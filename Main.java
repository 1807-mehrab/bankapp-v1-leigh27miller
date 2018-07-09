public class Main{
    private Parser parser;
    private Screen currentScreen; 

    public static void main(String[] args){ 
        Main app = new Main();
        app.play();
    }
    public Main() {
        createScreens();
        parser = new Parser();
    }

    private void createScreens() {
        Screen hello, withdraw, deposit, bye;

        hello = new Screen("Hello, Welcome to the Bank of Leigh");
        withdraw = new Screen("Withdraw money from your account");
        deposit  = new Screen("Deposit money into your account");
        bye = new Screen("Goodbye");

        withdraw.setExits("bye", bye);
        deposit.setExits("bye", bye);
        bye.setExits("bye", bye);

        currentScreen = hello;
    }

    public void play(){
        System.out.println();
        System.out.println("Welcome to the Bank of Leigh");
        System.out.println("Please select from the following menu");
        System.out.println("Withdraw");
        System.out.println("Deposit");
        System.out.println("Quit");

        





        boolean finished  = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thanks for choosing Bank of Leigh.");
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Error, invalid input");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals(command)) {
            goScreen(command);
            double amount;
            System.out.println("How much would you like to withdraw or deposit");
        } else if (commandWord.equals("help")) {
            System.out.println("Going back to main screen");
            System.out.println();
            parser.showCommands();
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void goScreen(Command command) {
        if(!command.hasSecondWord()) {
            //if there is no second word
            System.out.println("Would you like to make another transaction");
            return;
        }

        String direction = command.getSecondWord();

        //Try to leave current room
        Screen nextScreen = currentScreen.getExit(direction);

        if(nextScreen == null){
            System.out.println("Error, please pick a screen to go to");
        } else{
            currentScreen = nextScreen;
        }
    }

    private boolean quit(Command command){
        if(command.hasSecondWord()){
            System.out.println("Do you want to quit?");
            return false;
        } else{
            return true;
        }
    }
}