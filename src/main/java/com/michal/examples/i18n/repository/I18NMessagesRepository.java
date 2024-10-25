package com.michal.examples.i18n.repository;

import com.michal.examples.i18n.entity.I18NMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface I18NMessagesRepository extends JpaRepository<I18NMessageEntity, String>, PagingAndSortingRepository<I18NMessageEntity, String> {

    @Query("""
            select m
            from I18NMessageEntity m
            where m.customerId = :customerId
                or (m.customerId is null
                    and m.key not in (
                        select m2.key
                        from I18NMessageEntity m2
                        where m2.customerId = :customerId
                        )
                   )
            """)
    List<I18NMessageEntity> findI18NMessagesWithOverrides(@Param("customerId") String customerId
    );

    @Query("""
            select i18n
            from I18NMessageEntity i18n
            where (i18n.customerId = :customerId
                   or (i18n.customerId is null
                       and i18n.key not in (
                           select i18n2.key
                           from I18NMessageEntity i18n2
                           where i18n2.customerId = :customerId
                         )
                       )
                  )
              and i18n.module = :module
            """)
    List<I18NMessageEntity> findI18NMessagesForCustomerAndModuleWithOverrides(@Param("customerId") String customerId,
                                                                              @Param("module") String module);

    @Query("""
            select i18n
            from I18NMessageEntity i18n
            where (i18n.customerId = :customerId
                   or (i18n.customerId is null
                       and i18n.key not in (
                           select i18n2.key
                           from I18NMessageEntity i18n2
                           where i18n2.customerId = :customerId
                         )
                       )
                  )
              and i18n.locale = :languageCode
            """)
    List<I18NMessageEntity> findI18NMessagesForCustomerAndLanguageCodeWithOverrides(@Param("customerId") String customerId,
                                                                                    @Param("languageCode") String languageCode);

    @Query("""
            select i18n
            from I18NMessageEntity i18n
            where (i18n.customerId = :customerId
                   or (i18n.customerId is null
                       and i18n.key not in (
                           select i18n2.key
                           from I18NMessageEntity i18n2
                           where i18n2.customerId = :customerId
                         )
                       )
                  )
              and i18n.module = :module
              and i18n.locale = :languageCode
            """)
    List<I18NMessageEntity> findI18NMessagesForCustomerAndModuleAndLanguageCodeWithOverrides(@Param("customerId") String customerId,
                                                                                             @Param("module") String module,
                                                                                             @Param("languageCode") String languageCode);
}
