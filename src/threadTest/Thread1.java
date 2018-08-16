package threadTest;

public class Thread1{

	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					bussiness.a();
				}
			}
		}).start();
		for (int i = 0; i < 3; i++) {
			bussiness.b();
		}
	}
}
	class Bussiness{
		private boolean flag = true;
		public synchronized void a(){
			while(flag) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(i);
			}
			flag=true;
			notify();
		}
		
		
		public synchronized void b() {
			while(!flag) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
			}
			flag=false;
			notify();
		}
	}
	

