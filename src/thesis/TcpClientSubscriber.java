package thesis;

import java.util.Optional;

public interface TcpClientSubscriber {
	public Optional<String> processMessage(String message);
}
