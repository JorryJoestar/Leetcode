class MovingAverage {
	int size;
	Queue<Integer> queue;

	public MovingAverage(int size){
		this.size = size;
		queue = new LinkedList<>();
	}

	public double next(int val){
		if(queue.size()==size)
			queue.poll();
		queue.add(val);
		double sum = 0;
		for(int i=0;i<queue.size();i++){
			int tmp = queue.poll();
			sum += tmp;
			queue.add(tmp);
		}
		return sum / queue.size();
	}
}