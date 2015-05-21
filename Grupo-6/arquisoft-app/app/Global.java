import java.text.SimpleDateFormat;
import java.util.Date;

import model.Doctor;
import model.EpisodioDeDolor;
import model.Paciente;
import model.SecurityRole;
import model.SecurityRole.Builder;
import play.Application;
import play.GlobalSettings;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;


public class Global extends GlobalSettings {

	/**
	 * Initialize the system with some sample contacts.
	 * @param app The application.
	 */
	@Transactional
	public void onStart(Application app) 
	{
		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable 
			{

				Doctor d=new Doctor("admin", "admin", "admin");
				Builder b=new Builder();
				b.roleName("admin");
				SecurityRole s=b.build();
				s.id=(long) 1;
				
				if(JPA.em().find(SecurityRole.class, (long) 1) == null)
				{
					JPA.em().persist(s);
					d.agregarRol(s);
					JPA.em().persist(d);
				}
				
				Doctor d1=new Doctor("doctor", "doctor", "doctor");
				Builder b1=new Builder();
				b.roleName("doctor");
				SecurityRole s1=b.build();
				s1.id=(long) 2;
				
				if(JPA.em().find(SecurityRole.class, (long) 2) == null)
				{
					JPA.em().persist(s1);
					d1.agregarRol(s1);
					JPA.em().persist(d1);
				}
				
				Date myDate = new Date();
				SimpleDateFormat sm = new SimpleDateFormat ("mm-dd-yyyy");
				String strDate = sm.format(myDate);
				 Date dt = sm.parse(strDate);

				 
				Paciente a = new Paciente((long)1020781651, "Juan", "Rozo",dt, "Masculino", 6198109, "s.lol10");
				Paciente a2 = new Paciente((long)41711505, "Andres", "Murillo", dt, "Masculino", 6135192, "jn.sin10");
				Paciente a3 = new Paciente((long)1010123592, "Elkin", "Siachoque", dt, "Masculino", 6135192, "sk.siac10");
				Paciente a4 = new Paciente((long)1020505923, "Jorge", "Villanoba", dt, "Masculino", 6135192, "jo.villa");
				Paciente a5 = new Paciente((long)1049238252, "Alberto", "Luna", dt, "Masculino", 6135192, "da.luna10");
				
				Paciente a6 = new Paciente((long)1010200422, "Manuela", "Sanchez", dt, "Femenino", 6135192, "ella1.sin10");
				Paciente a7 = new Paciente((long)1020750232, "Alejandra", "Lopez", dt, "Femenino", 6135192, "ella2.sin10");
				Paciente a8 = new Paciente((long)1020482732, "Carolina", "Sandoval", dt, "Femenino", 6135192, "ella3.sin10");
				Paciente a9 = new Paciente((long)1020849232, "Camila", "Cardenas", dt, "Femenino", 6135192, "ella4.sin10");
				Paciente a10 = new Paciente((long)102349223, "Lorena", "Barreto", dt, "Femenino", 6135192, "ella5.sin10");
				
				EpisodioDeDolor e = new EpisodioDeDolor(dt, "7", 12, "Casa", (long)1020781651);
				EpisodioDeDolor e1 = new EpisodioDeDolor(dt, "4", 8, "Trabajo", (long)1020781651);
				EpisodioDeDolor e2 = new EpisodioDeDolor(dt, "5", 4, "Parque", (long)1020781651);
				EpisodioDeDolor e3 = new EpisodioDeDolor(dt, "9", 7, "Casa", (long)1020781651);
				EpisodioDeDolor e4 = new EpisodioDeDolor(dt, "10", 2, "Colegio", (long)1020781651);

				


				 
				if(JPA.em().find(Paciente.class, (long)4171150) == null){
				
					JPA.em().persist(a);
					JPA.em().persist(a2);
					JPA.em().persist(a3);
					JPA.em().persist(a4);
					JPA.em().persist(a5);
					JPA.em().persist(a6);
					JPA.em().persist(a7);
					JPA.em().persist(a8);
					JPA.em().persist(a9);
					JPA.em().persist(a10);
					JPA.em().persist(e);
					JPA.em().persist(e1);
					JPA.em().persist(e2);
					JPA.em().persist(e3);
					JPA.em().persist(e4);
					
//					
					
				}
				

				
			}
		});

	}

}

