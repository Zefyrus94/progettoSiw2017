package it.uniroma3.galleria.security;
//DataSource
import javax.sql.DataSource;
//@Autowired
import org.springframework.beans.factory.annotation.Autowired;
//@Qualifier
import org.springframework.beans.factory.annotation.Qualifier;
/*import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;*/
//@Configuration
import org.springframework.context.annotation.Configuration;
/*import org.springframework.boot.web.servlet.ErrorPage;*/
//@Bean
import org.springframework.context.annotation.Bean;
/*import org.springframework.http.HttpStatus;*/
//AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//@EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//HttpSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//@EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//extends WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//BCryptPasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//InMemoryUserDetailsManagerConfigurer
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;

	@Autowired
	private RedirectLoginSuccessHandler loginSuccessHandler;

	@Autowired
	private RedirectLogoutSuccessHandler logoutSuccessHandler;

	private String selectFromUtenti="SELECT username, password, 1 FROM utenti WHERE username = ?";
	private String selectFromRuoli= "SELECT u.username, ruoli.ruolo authority " +
				"FROM utenti u JOIN ruoli_utente ruoli ON u.id = ruoli.utente_id WHERE u.username = ?";
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
	inMemoryConfigurer() {
		return new InMemoryUserDetailsManagerConfigurer<>();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder())
		.usersByUsernameQuery(selectFromUtenti)
		.authoritiesByUsernameQuery(selectFromRuoli);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.inMemoryAuthentication()
            .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN");
		//
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery(selectFromUtenti)
		.authoritiesByUsernameQuery(selectFromRuoli);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.formLogin()
		.loginPage("/accedi")
		.permitAll()
		.successHandler(loginSuccessHandler)
		.and()
		.authorizeRequests()
		.antMatchers("/","/signup","/img/**","/fonts/**","/js/**","/less/**","/vendor/**",
				"/css/**","/home","/user/**","/artista/**","/artista/**","/opera/**","/opera",
				"/opere","/opere/**","/uploadFrom**","/gellallfiles","/upload/**","/upload",
				"/admin/**","/admin", "/accesso", "/logout", "../js/**","/log_admin","/accessoadmin")
		.permitAll()
		.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessHandler(logoutSuccessHandler);
	}
}