package com.languages.languages;

import com.languages.languages.domain.Language;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LanguageRepository extends ReactiveCrudRepository<Language, String> {
}
