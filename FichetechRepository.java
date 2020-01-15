package pro.novalog.booking.api.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pro.novalog.booking.api.domain.entity.Fichetech;
import pro.novalog.booking.api.domain.entity.Departement;
public interface FichetechRepository extends JpaRepository<Fichetech, String> {

	@Query("select f.ftLibelle, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='01' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca01," 
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='01' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte01, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='02' and ca.chiffreFiche.idFiche=f.idFiche),0) as  Ca02, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='02' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte02, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='03' and ca.chiffreFiche.idFiche=f.idFiche),0) as  Ca03, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='03' and ca.chiffreFiche.idFiche=f.idFiche),0)as  qte03, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='04' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca04, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='04' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte04, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='05' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca05, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='05' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte05, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='06' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca06, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.chiffreDepartement.idDep='06' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte06 "
			+" from Fichetech f "
			+ "where coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.chiffreFiche.idFiche=f.idFiche),0)> 0 "
			+" order by 1  ")
	public List<Object[]> tableauVenteDetail(@Param("annee") String annee);
	
	
	
	
	@Query("select f.ftLibelle, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='01' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca01," 
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and  ca.chiffreDepartement.idDep='01' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte01, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='02' and ca.chiffreFiche.idFiche=f.idFiche),0) as  Ca02, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='02' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte02, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='03' and ca.chiffreFiche.idFiche=f.idFiche),0) as  Ca03, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='03' and ca.chiffreFiche.idFiche=f.idFiche),0)as  qte03, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='04' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca04, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='04' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte04, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='05' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca05, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='05' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte05, "
			+" coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='06' and ca.chiffreFiche.idFiche=f.idFiche),0) as Ca06, "
			+" coalesce((select round(sum(ca.quantite),0) from ChiffreAffaire ca    where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreDepartement.idDep='06' and ca.chiffreFiche.idFiche=f.idFiche),0) as qte06 "
			+" from Fichetech f "
			+ "where coalesce((select round(sum(ca.chiffreAffaire),0) from ChiffreAffaire ca  where ca.chiffreDate.annee = :annee and ca.ve_datetck between :dt1 and :dt2 and ca.chiffreFiche.idFiche=f.idFiche),0)> 0 "
			+" order by 1  ")
	public List<Object[]> tableauVenteDetailJour(@Param("annee") String annee, @Param("dt1") Date dt1 ,@Param("dt2") Date  dt2);
}
