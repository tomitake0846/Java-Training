//package ch16.ex11;
//
//public class Game {
//	public static void main(String[] args) {
//		String name;//クラス名
//		while((name = getNextPlayer()) != null) {
//			try {
//				PlayerLoader loader = new PlayerLoader();
//				Class<? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
//				Player player = classOf.newInstance();
//				Game game = new Game();
//				playerplay(game);
//				game.reportScore(name);
//			} catch (Exception e) {
//				reportException(name,e);
//			}
//		}
//	}
//}
