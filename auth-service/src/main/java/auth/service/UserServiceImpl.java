package auth.service;

import auth.domain.User;
import auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	private final UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(User user) {

		Optional<User> existing = repository.findById(user.getUsername());
		existing.ifPresent(it-> {throw new IllegalArgumentException("user already exists: " + it.getUsername());});

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);

		repository.save(user);

		log.info("new user has been created: {}", user.getUsername());
	}
}
