package next.controller;

import core.annotation.web.Controller;
import core.annotation.web.RequestMapping;
import core.annotation.web.RequestMethod;
import core.annotation.web.RequestParam;
import core.db.DataBase;
import core.mvc.JsonView;
import core.mvc.ModelAndView;
import next.dto.UserCreatedDto;
import next.dto.UserUpdatedDto;
import next.model.User;
import org.springframework.http.HttpStatus;

/**
 * Created By kjs4395 on 6/30/20
 */
@Controller
public class UserApiController {

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public ModelAndView createUser(UserCreatedDto userCreatedDto) {
        DataBase.addUser(userCreatedDto.userCreateDtoToUser());

        return new ModelAndView(new JsonView(HttpStatus.CREATED, "/api/users?userId=" + userCreatedDto.getUserId()));
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam String userId) {
        User user = DataBase.findUserById(userId);
        ModelAndView modelAndView = new ModelAndView(new JsonView());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.PUT)
    public ModelAndView modifyUser(@RequestParam String userId, UserUpdatedDto userUpdatedDto) {
        User user = DataBase.findUserById(userId);
        user.updateUser(userUpdatedDto);
        return new ModelAndView(new JsonView());
    }

}