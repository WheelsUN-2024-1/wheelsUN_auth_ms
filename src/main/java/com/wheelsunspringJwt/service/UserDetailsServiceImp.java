    package com.wheelsunspringJwt.service;

    import com.wheelsunspringJwt.repository.UserRepository;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    @Service
    public class UserDetailsServiceImp implements UserDetailsService {

        private final UserRepository repository;

        public UserDetailsServiceImp(UserRepository repository) {
            this.repository = repository;
        }

        @Override
        public UserDetails loadUserByUsername(String userId ) throws UsernameNotFoundException {
            return repository.findByUserId(userId)
                    .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        }
    }
