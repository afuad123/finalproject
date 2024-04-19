The Ecosystem Simulator is designed to enable users to add plants, herbivores (plant eaters), carnivores (meat eaters), and humans to 
a simulated ecosystem. The only aspects of these objects the user can control are the size and growth rate of the objects. Food need of 
all objects are 15% the size of the object. The user can control when to make an object eat/hunt another object. In this scenario,
the most recently added object will eat a random object of the target group. For example, out of 3 meat eaters, the 3rd meat eater 
(the one added most recently) will eat a randomly determined plant eater out of 3 plant eaters. When the user simulates a day,
each object grows by its assigned growth rate and its age increases by one day. 

Limitations: I wasn't able to add a "game" functionality to the project with the time I had. While the user can do whatever
they want to the ecosystem, I didn't add any target goals or boundaries for the user to reach. I began to do that with my
polluteAir() and commute() methods in the human class which would introduce threats to the ecosystem (that could be counteracted
by say, adding more plants), but I never fully implemented them. 