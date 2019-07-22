package by.training.gym.view.tag;

import by.training.gym.service.DiscountService;
import by.training.gym.service.ServiceException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
/**
 * discount tag class.
 * @author AlesyaHlushakova
 */

public class DiscountTag extends TagSupport {

    private String id;

    /**
     * setter for id.
     * @param id the id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method starts tag.
     *
     * @return int constant SKIP_BODY.
     * @throws JspException object if execution of method is failed.
     */
    @Override
    public int doStartTag() throws JspException {
        try {
            DiscountService discountService = new DiscountService();
            int clientId = Integer.parseInt(id);
            int discount = discountService.getDiscount(clientId);
            JspWriter jspWriter = pageContext.getOut();
            jspWriter.write(String.format("%d%%):", discount));
        } catch (IOException | ServiceException exception) {
            throw new JspException("Menu tag failed.",exception);
        }
        return SKIP_BODY;
    }
}
