package com.languages.languages;

import com.languages.languages.domain.Language;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LanguageRepository extends ReactiveMongoRepository<Language, String> {
}
