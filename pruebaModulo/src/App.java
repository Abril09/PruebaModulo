
import controller.GameController;
import controller.Logic;
import utils.State;
import views.OscurilandiaView;

public class App {
	private static Logic logic;
	private static OscurilandiaView view;

	private static void play() {
		logic = new Logic();
		view = new OscurilandiaView();
		do {
			try {
				GameController controller = logic.getController();
				logic.printBoard();
				if (controller != null) {
					view.invocate(controller);
				}
		
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (logic.getGameState() != State.END);		
	}

	public static void main(String[] args) throws Exception {
		play();
	}
}
