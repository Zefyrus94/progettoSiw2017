//package it.uniroma3.spring.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class OriginSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.jdbcAuthentication().dataSource(dataSource)
//
//		.passwordEncoder(new BCryptPasswordEncoder())
//		.usersByUsernameQuery("SELECT username,password,enabled FROM users where username=?")
//		//.authoritiesByUsernameQuery("SELECT username,authority FROM authorities where username=?");
//		.authoritiesByUsernameQuery("SELECT u.username, ruoli.ruolo authority " +
//				"FROM users u JOIN ruoli_utente ruoli ON u.id = ruoli.user_role_id WHERE u.username = ?");
//	}
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//		.antMatchers("/","/signUp","/IMG/**", "/css/**","/home","/user/**","/artisti/**")
//		.permitAll()
//		.antMatchers("/","/signup","/img/**","/fonts/**","/js/**","/less/**","/vendor/**",
//				"/css/**","/home","/user/**","/opera/**","/opera",
//				"/opere","/opere/**","/uploadFrom**","/gellallfiles","/upload/**","/upload")
//		.permitAll()
//		.antMatchers("/artista/**","/artisti").hasRole("USER")
//		//.antMatchers("/admin/**","/artista/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll();
//	}
//}