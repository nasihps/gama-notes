package com.wecp.library.controller;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IssueRepository issueRepository;

    @PostMapping("/issue-book")
    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue) {
        Optional<User> userOpt = userRepository.findById(issue.getUser().getId());
        if(userOpt.isPresent() && userOpt.get().getSubscribed()){
            Issue savedIssue = issueRepository.save(issue);
            return ResponseEntity.ok(savedIssue);
        }
        else{
            throw new UserNotSubscribedException();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("renew-user-subscription/{id}")
    public ResponseEntity<User> renewUserSubscription(@PathVariable Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setSubscribed(true);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
}