package com.AppDirect.jBilling.store;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreEntity,UUID>{}
