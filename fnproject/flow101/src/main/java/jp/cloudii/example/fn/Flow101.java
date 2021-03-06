package jp.cloudii.example.fn;

import com.fnproject.fn.api.FnFeature;
import com.fnproject.fn.api.flow.Flow;
import com.fnproject.fn.api.flow.Flows;
import com.fnproject.fn.runtime.flow.FlowFeature;

@FnFeature(FlowFeature.class)
public class Flow101 {
	public String handleRequest(int x) {
		Flow fl = Flows.currentFlow();

		return fl.completedValue(x)
				.thenApply( i -> i * 2 )
				.thenApply( i -> "Your number is " + i )
				.get();
	}
}