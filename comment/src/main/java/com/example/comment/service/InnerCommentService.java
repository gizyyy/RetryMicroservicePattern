package com.example.comment.service;

import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class InnerCommentService {

	@Transactional(value = TxType.REQUIRES_NEW)
	@Retryable(value = { RuntimeException.class }, maxAttempts = 2, backoff = @Backoff(delay = 1000))
	public void putComment(int productId) {
		int nextInt = ThreadLocalRandom.current().nextInt(10, 5000);
		if (nextInt > 1000) {
			System.out.println("Im failed");
			throw new RuntimeException();
		}
		// putting to comment deep inside somewhere over the rainbow
		System.out.println("Im successfull");
	}
}
