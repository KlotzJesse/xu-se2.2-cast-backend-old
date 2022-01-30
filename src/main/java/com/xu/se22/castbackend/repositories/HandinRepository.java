package com.xu.se22.castbackend.repositories;

import com.xu.se22.castbackend.models.Handin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HandinRepository extends CrudRepository<Handin, Integer> {

    @Query("select h from handins h WHERE h.account.AccountID = ?1 AND h.handindate = (SELECT max(h2.handindate) FROM handins h2 WHERE h.account = h2.account)")
    Handin findLatestHandIn(Integer accountId);

    @Query("select h.handindate, h.publication.Name from handins h WHERE h.account.AccountID = ?1 AND h.publication IS NOT NULL AND h.handindate = (SELECT max(h2.handindate) FROM handins h2 WHERE h.account = h2.account AND h.publication IS NOT NULL)")
    String[] findLatestPublicationHandIn(Integer accountId);

    @Query("select h.handindate, h.project.ProjectName from handins h WHERE h.account.AccountID = ?1 AND h.project IS NOT NULL AND h.handindate = (SELECT max(h2.handindate) FROM handins h2 WHERE h.account = h2.account AND h.project IS NOT NULL)")
    String[] findLatestProjectHandIn(Integer accountId);

    @Query("select DISTINCT h.account.AccountID, max(h.handindate) from handins h WHERE h.publication IS NOT NULL GROUP BY h.account.AccountID")
    String[] findHandInsFromPublication();

    @Query("select DISTINCT h.account.AccountID, max(h.handindate) from handins h WHERE h.project IS NOT NULL GROUP BY h.account.AccountID")
    String[] findHandInsFroProjects();

}
